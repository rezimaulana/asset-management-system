import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { QuizMaterialResDto } from "src/app/dto/quiz-material/quiz-material.res.dto";
import { QuizMaterialService } from "src/app/service/quiz-material.service";

@Component({
    selector : 'quiz-material-detail-std',
    templateUrl : './quiz-material-detail.student.component.html'
})
export class QuizMaterialDetailComponentStudent implements OnInit, OnDestroy{
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    quizMaterialResDto = new QuizMaterialResDto()
    classDtlId! : number
    
    private quizMaterialGetByIdSubscription? : Subscription
    private getClassDtlIdSubscription? : Subscription
    
    constructor(private activated : ActivatedRoute, private quizMaterialService : QuizMaterialService){}

    init(){
        this.quizMaterialGetByIdSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.quizMaterialService.getById(idnum).subscribe(result => {
                this.quizMaterialResDto = result
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
        this.quizMaterialGetByIdSubscription?.unsubscribe()
        this.getClassDtlIdSubscription?.unsubscribe()
    }
}