import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { AttendanceInsertReqDto } from "src/app/dto/attendance/attendance.insert.req.dto";
import { AttendanceListResDto } from "src/app/dto/attendance/attendance.list.res.dto";
import { AttendanceUpdateReqDto } from "src/app/dto/attendance/attendance.update.req.dto";
import { AttendanceService } from "src/app/service/attendance.service";

@Component({
    selector: 'exam-attendance-list-ins',
    templateUrl: './exam-attendance-list.instructor.component.html'
})
export class ExamAttendanceListComponentInstructor implements OnInit, OnDestroy {
    attendanceListResDto = new AttendanceListResDto()
    attendanceUpdateReqDto = new AttendanceUpdateReqDto
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    classHdrId!: number
    materialId!: number
    scheduleId!: number

    private attendanceGetAttendExamSubscription?: Subscription
    private getClassHdrIdSubscription?: Subscription
    private getMaterialIdSubscription?: Subscription
    private getScheduleIdSubscription?: Subscription
    private attendanceUpdateSubscription?: Subscription

    constructor(private activated: ActivatedRoute, private attendanceService: AttendanceService) { }

    init() {
        this.getScheduleIdSubscription = this.activated.params.subscribe(id => {
            this.scheduleId = Number(Object.values(id))
        })
        this.getMaterialIdSubscription = this.activated.parent?.parent?.parent?.params.subscribe(id => {
            this.materialId = Number(Object.values(id))
        })
        this.getClassHdrIdSubscription = this.activated.parent?.parent?.parent?.parent?.params.subscribe(id => {
            this.classHdrId = Number(Object.values(id))
        })
        this.attendanceGetAttendExamSubscription = this.attendanceService.getAttendExam(this.scheduleId).subscribe(result => {
            this.attendanceListResDto = result
        })
    }

    ngOnInit(): void {
        this.init()
    }

    submit(id:number, ver:number) {
        // this.a
        this.attendanceUpdateReqDto._id = id
        this.attendanceUpdateReqDto._approval = true
        this.attendanceUpdateReqDto._ver = ver
        this.attendanceUpdateSubscription = this.attendanceService.update(this.attendanceUpdateReqDto).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.attendanceGetAttendExamSubscription?.unsubscribe()
        this.getClassHdrIdSubscription?.unsubscribe()
        this.getMaterialIdSubscription?.unsubscribe()
        this.getScheduleIdSubscription?.unsubscribe()
        this.attendanceUpdateSubscription?.unsubscribe()
    }
}