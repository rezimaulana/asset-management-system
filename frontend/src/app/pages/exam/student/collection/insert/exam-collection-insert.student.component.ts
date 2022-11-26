import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Subscription } from "rxjs";
import { ClassDtlResDto } from "src/app/dto/class-dtl/class-dtl.res.dto";
import { ExamCollectionInsertReqDto } from "src/app/dto/exam-collection/exam-collection.insert.req.dto";
import { ExamScheduleResDto } from "src/app/dto/exam-schedule/exam-schedule.res.dto";
import { ClassDtlService } from "src/app/service/class-dtl.service";
import { ExamCollectionService } from "src/app/service/exam-collection.service";
import { ExamMaterialService } from "src/app/service/exam-material.service";
import { ExamScheduleService } from "src/app/service/exam-schedule.service";
import { FileService } from "src/app/service/file.service";

@Component({
    selector : 'exam-collection-insert-std',
    templateUrl : './exam-collection-insert.student.component.html'
})
export class ExamCollectionInsertComponentStudent implements OnInit, OnDestroy{
    
    classDtlId! : number
    scheduleId! : number
    classDtlResDto = new ClassDtlResDto()
    examScheduleResDto = new ExamScheduleResDto()
    examCollectionInsertReqDto = new ExamCollectionInsertReqDto()

    private classDtlGetByIdSubscription? : Subscription
    private scheduleGetByIdSubscription? : Subscription
    private collectionInsertSubscription? : Subscription

    constructor(private activated : ActivatedRoute, private classDtlService : ClassDtlService,
        private examScheduleService : ExamScheduleService, private fileService : FileService,
        private examCollectionService : ExamCollectionService, private router : Router){}
    
    ngOnInit(): void {
        this.classDtlGetByIdSubscription = this.activated.parent?.parent?.parent?.params.subscribe(id => {
            this.classDtlId = Number(Object.values(id))
            this.classDtlService.getById(this.classDtlId).subscribe(result => {
                this.classDtlResDto = result
            })
        })
        this.scheduleGetByIdSubscription = this.activated.parent?.params.subscribe(id => {
            this.scheduleId = Number(Object.values(id))
            this.examScheduleService.getById(this.scheduleId).subscribe(result => {
                this.examScheduleResDto = result
            })
        })
    }

    submit() : void{
        this.examCollectionInsertReqDto._classDtlId = this.classDtlId
        this.examCollectionInsertReqDto._examScheduleId = this.scheduleId
        this.collectionInsertSubscription = this.examCollectionService.insert(this.examCollectionInsertReqDto).subscribe(() =>{
            this.router.navigateByUrl(`/exam/student/class-dtl/${this.classDtlId}/schedule`)
        })
    }

    fileUpload(event: any) {
        this.fileService.fileUpload(event).then(result=>{
            this.examCollectionInsertReqDto._fileExt=result[0]
            this.examCollectionInsertReqDto._fileCode=result[1]
        })
    }

    ngOnDestroy(): void {
        this.classDtlGetByIdSubscription?.unsubscribe()
        this.scheduleGetByIdSubscription?.unsubscribe()
        this.collectionInsertSubscription?.unsubscribe()
    }

}