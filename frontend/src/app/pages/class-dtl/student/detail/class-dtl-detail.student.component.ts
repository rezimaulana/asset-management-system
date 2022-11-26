import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "../../../../constant/base.url";
import { ClassDtlResDto } from "../../../../dto/class-dtl/class-dtl.res.dto";
import { ClassDtlService } from "../../../../service/class-dtl.service";

@Component({
    selector : 'class-dtl-detail-std',
    templateUrl : './class-dtl-detail.student.component.html'
})
export class ClassDtlDetailComponentStudent implements OnInit, OnDestroy{
    
    classDtlResDto = new ClassDtlResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private classDtlGetByIdSubcription? : Subscription

    constructor(private activated : ActivatedRoute, private classDtlService : ClassDtlService){}
    
    ngOnInit(): void {
        this.classDtlGetByIdSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classDtlService.getById(idnum).subscribe(result => {
                this.classDtlResDto = result
            })
        })
    }
    ngOnDestroy(): void {
        this.classDtlGetByIdSubcription?.unsubscribe()
    }
    
}