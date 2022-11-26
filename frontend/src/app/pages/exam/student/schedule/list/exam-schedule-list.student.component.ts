import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { AttendanceInsertReqDto } from "src/app/dto/attendance/attendance.insert.req.dto";
import { ExamScheduleListResDto } from "src/app/dto/exam-schedule/exam-schedule.list.res.dto";
import { AttendanceService } from "src/app/service/attendance.service";
import { ExamScheduleService } from "src/app/service/exam-schedule.service";

@Component({
    selector : 'exam-schedule-list-std',
    templateUrl : './exam-schedule-list.student.component.html'
})
export class ExamScheduleListComponentStudent implements OnInit, OnDestroy{
    examScheduleListResDto = new ExamScheduleListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    classDtlId! : number
    attendanceInsertReqDto = new AttendanceInsertReqDto()

    private examScheduleGetAllIdClassDtlSubcription? : Subscription
    private attendanceInsertSubscription? : Subscription

    constructor(private activated : ActivatedRoute, private examScheduleService : ExamScheduleService,
        private attendanceService : AttendanceService){}
    
    init(){
        this.examScheduleGetAllIdClassDtlSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classDtlId = idnum
            this.examScheduleService.getAllIdClassDtl(idnum).subscribe(result => {
                this.examScheduleListResDto = result
            })
        })
    }

    ngOnInit(): void {
        this.init()
    }

    insert(classStdId : number, examScheduleId : number) : void {
        this.attendanceInsertReqDto._classDtlId = classStdId
        this.attendanceInsertReqDto._examScheduleId = examScheduleId
        this.attendanceInsertSubscription = this.attendanceService.insert(this.attendanceInsertReqDto).subscribe(() =>{
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.examScheduleGetAllIdClassDtlSubcription?.unsubscribe()
        this.attendanceInsertSubscription?.unsubscribe()
    }
}