import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Subscription } from "rxjs";
import { ClassDtlResDto } from "src/app/dto/class-dtl/class-dtl.res.dto";
import { QuizCollectionInsertReqDto } from "src/app/dto/quiz-collection/quiz-collection.insert.req.dto";
import { QuizScheduleResDto } from "src/app/dto/quiz-schedule/quiz-schedule.res.dto";
import { ClassDtlService } from "src/app/service/class-dtl.service";
import { FileService } from "src/app/service/file.service";
import { QuizCollectionService } from "src/app/service/quiz-collection.service";
import { QuizScheduleService } from "src/app/service/quiz-schedule.service";

@Component({
    selector : 'quiz-collection-insert-std',
    templateUrl : './quiz-collection-insert.student.component.html'
})
export class QuizCollectionInsertComponentStudent implements OnInit, OnDestroy{
    classDtlId! : number
    scheduleId! : number
    classDtlResDto = new ClassDtlResDto()
    quizScheduleResDto = new QuizScheduleResDto()
    quizCollectionInsertReqDto = new QuizCollectionInsertReqDto()

    private classDtlGetByIdSubscription? : Subscription
    private scheduleGetByIdSubscription? : Subscription
    private collectionInsertSubscription? : Subscription

    constructor(private activated : ActivatedRoute, private classDtlService : ClassDtlService,
        private quizScheduleService : QuizScheduleService, private fileService : FileService,
        private quizCollectionService : QuizCollectionService, private router : Router){}
    
    ngOnInit(): void {
        this.classDtlGetByIdSubscription = this.activated.parent?.parent?.parent?.params.subscribe(id => {
            this.classDtlId = Number(Object.values(id))
            this.classDtlService.getById(this.classDtlId).subscribe(result => {
                this.classDtlResDto = result
            })
        })
        this.scheduleGetByIdSubscription = this.activated.parent?.params.subscribe(id => {
            this.scheduleId = Number(Object.values(id))
            this.quizScheduleService.getById(this.scheduleId).subscribe(result => {
                this.quizScheduleResDto = result
            })
        })
    }

    submit() : void{
        this.quizCollectionInsertReqDto._classDtlId = this.classDtlId
        this.quizCollectionInsertReqDto._quizScheduleId = this.scheduleId
        this.collectionInsertSubscription = this.quizCollectionService.insert(this.quizCollectionInsertReqDto).subscribe(() =>{
            this.router.navigateByUrl(`/quiz/student/class-dtl/${this.classDtlId}/schedule`)
        })
    }

    fileUpload(event: any) {
        this.fileService.fileUpload(event).then(result=>{
            this.quizCollectionInsertReqDto._fileExt=result[0]
            this.quizCollectionInsertReqDto._fileCode=result[1]
        })
    }

    ngOnDestroy(): void {
        this.classDtlGetByIdSubscription?.unsubscribe()
        this.scheduleGetByIdSubscription?.unsubscribe()
        this.collectionInsertSubscription?.unsubscribe()
    }
}