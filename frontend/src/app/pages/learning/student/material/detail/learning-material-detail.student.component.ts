import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { LearningMaterialResDto } from "src/app/dto/learning-material/learning-material.res.dto";
import { LearningMaterialService } from "src/app/service/learning-material.service";

@Component({
    selector : 'learning-material-detail-std',
    templateUrl : './learning-material-detail.student.component.html'
})
export class LearningMaterialDetailComponentStudent implements OnInit, OnDestroy{
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    learningMaterialResDto = new LearningMaterialResDto()
    classDtlId! : number
    
    private learningMaterialGetByIdSubscription? : Subscription
    private getClassDtlIdSubscription? : Subscription
    
    constructor(private activated : ActivatedRoute, private learningMaterialService : LearningMaterialService){}

    init(){
        this.learningMaterialGetByIdSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.learningMaterialService.getById(idnum).subscribe(result => {
                this.learningMaterialResDto = result
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
        this.learningMaterialGetByIdSubscription?.unsubscribe()
        this.getClassDtlIdSubscription?.unsubscribe()
    }
}