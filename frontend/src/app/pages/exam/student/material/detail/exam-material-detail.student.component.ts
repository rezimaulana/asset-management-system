import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ExamMaterialResDto } from "src/app/dto/exam-material/exam-material.res.dto";
import { ExamMaterialService } from "src/app/service/exam-material.service";

@Component({
    selector : 'exam-material-detail-std',
    templateUrl : './exam-material-detail.student.component.html'
})
export class ExamMaterialDetailComponentStudent implements OnInit, OnDestroy{
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    examMaterialResDto = new ExamMaterialResDto()
    classDtlId! : number
    
    private examMaterialGetByIdSubscription? : Subscription
    private getClassDtlIdSubscription? : Subscription
    
    constructor(private activated : ActivatedRoute, private examMaterialService : ExamMaterialService){}

    init(){
        this.examMaterialGetByIdSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.examMaterialService.getById(idnum).subscribe(result => {
                this.examMaterialResDto = result
            })
        })
        this.getClassDtlIdSubscription = this.activated.parent?.parent?.parent?.params.subscribe(id => {
            this.classDtlId = Number(Object.values(id))
        })
    }

    ngOnInit(): void {
        this.init()
    }

    ngOnDestroy(): void {
        this.examMaterialGetByIdSubscription?.unsubscribe()
        this.getClassDtlIdSubscription?.unsubscribe()
    }
}