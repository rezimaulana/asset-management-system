import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ExamMaterialListResDto } from "src/app/dto/exam-material/exam-material.list.res.dto";
import { ExamMaterialService } from "src/app/service/exam-material.service";

@Component({
    selector : 'exam-material-list-ins',
    templateUrl : './exam-material-list.instructor.component.html'
})
export class ExamMaterialListComponentInstructor implements OnInit, OnDestroy{
    examMaterialListResDto = new ExamMaterialListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    classHdrId! : number

    private examMaterialGetAllIdClassHdrSubcription? : Subscription

    constructor(private activated : ActivatedRoute, private examMaterialService : ExamMaterialService){}
    
    init(){
        this.examMaterialGetAllIdClassHdrSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classHdrId = idnum
            this.examMaterialService.getAllIdClassHdr(idnum).subscribe(result => {
                this.examMaterialListResDto = result
            })
        })
    }

    ngOnInit(): void {
        this.init()
    }

    ngOnDestroy(): void {
        this.examMaterialGetAllIdClassHdrSubcription?.unsubscribe()
    }
}