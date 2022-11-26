import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { AttendanceInsertReqDto } from "src/app/dto/attendance/attendance.insert.req.dto";
import { LearningScheduleListResDto } from "src/app/dto/learning-schedule/learning-schedule.list.res.dto";
import { AttendanceService } from "src/app/service/attendance.service";
import { LearningScheduleService } from "src/app/service/learning-schedule.service";

@Component({
    selector : 'learning-schedule-list-std',
    templateUrl : './learning-schedule-list.student.component.html'
})
export class LearningScheduleListComponentStudent implements OnInit, OnDestroy{
    learningScheduleListResDto = new LearningScheduleListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    classDtlId! : number
    attendanceInsertReqDto = new AttendanceInsertReqDto()

    private learningScheduleGetAllIdClassDtlSubcription? : Subscription
    private attendanceInsertSubscription? : Subscription

    constructor(private activated : ActivatedRoute, private learningScheduleService : LearningScheduleService,
        private attendanceService : AttendanceService){}
    
    init(){
        this.learningScheduleGetAllIdClassDtlSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classDtlId = idnum
            this.learningScheduleService.getAllIdClassDtl(idnum).subscribe(result => {
                this.learningScheduleListResDto = result
            })
        })
    }

    ngOnInit(): void {
        this.init()
    }

    insert(classStdId : number, learningScheduleId : number) : void {
        this.attendanceInsertReqDto._classDtlId = classStdId
        this.attendanceInsertReqDto._learningScheduleId = learningScheduleId
        this.attendanceInsertSubscription = this.attendanceService.insert(this.attendanceInsertReqDto).subscribe(() =>{
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.learningScheduleGetAllIdClassDtlSubcription?.unsubscribe()
        this.attendanceInsertSubscription?.unsubscribe()
    }
}