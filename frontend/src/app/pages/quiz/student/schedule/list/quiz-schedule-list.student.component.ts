import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { AttendanceInsertReqDto } from "src/app/dto/attendance/attendance.insert.req.dto";
import { QuizScheduleListResDto } from "src/app/dto/quiz-schedule/quiz-schedule.list.res.dto";
import { AttendanceService } from "src/app/service/attendance.service";
import { QuizScheduleService } from "src/app/service/quiz-schedule.service";

@Component({
    selector : 'quiz-schedule-list-std',
    templateUrl : './quiz-schedule-list.student.component.html'
})
export class QuizScheduleListComponentStudent implements OnInit, OnDestroy{
    quizScheduleListResDto = new QuizScheduleListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    classDtlId! : number
    attendanceInsertReqDto = new AttendanceInsertReqDto()

    private quizScheduleGetAllIdClassDtlSubcription? : Subscription
    private attendanceInsertSubscription? : Subscription

    constructor(private activated : ActivatedRoute, private quizScheduleService : QuizScheduleService,
        private attendanceService : AttendanceService){}
    
    init(){
        this.quizScheduleGetAllIdClassDtlSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classDtlId = idnum
            this.quizScheduleService.getAllIdClassDtl(idnum).subscribe(result => {
                this.quizScheduleListResDto = result
            })
        })
    }

    ngOnInit(): void {
        this.init()
    }

    insert(classStdId : number, quizScheduleId : number) : void {
        this.attendanceInsertReqDto._classDtlId = classStdId
        this.attendanceInsertReqDto._quizScheduleId = quizScheduleId
        this.attendanceInsertSubscription = this.attendanceService.insert(this.attendanceInsertReqDto).subscribe(() =>{
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.quizScheduleGetAllIdClassDtlSubcription?.unsubscribe()
        this.attendanceInsertSubscription?.unsubscribe()
    }
}