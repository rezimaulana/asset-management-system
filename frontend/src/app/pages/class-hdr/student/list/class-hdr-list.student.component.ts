import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ClassDtlInsertReqDto } from "src/app/dto/class-dtl/class-dtl.insert.req.dto";
import { ClassHdrListResDto } from "src/app/dto/class-hdr/class-hdr.list.res.dto";
import { ClassDtlService } from "src/app/service/class-dtl.service";
import { ClassHdrService } from "src/app/service/class-hdr.service";

@Component({
    selector : 'class-hdr-list-std',
    templateUrl : './class-hdr-list.student.component.html'
})
export class ClassHdrListComponentStudent implements OnInit, OnDestroy{
    
    classHdrListResDto = new ClassHdrListResDto()
    classDtlInsertReqDto = new ClassDtlInsertReqDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private classHdrGetAllSubscription? : Subscription
    private classDtlInsertSubscription? : Subscription

    constructor(private classHdrService: ClassHdrService, private classDtlService : ClassDtlService){}

    init(){
        this.classHdrGetAllSubscription = this.classHdrService.getAll().subscribe(result => {
            this.classHdrListResDto = result
        })
    }
    
    ngOnInit(): void {
        this.init()
    }

    submit(classHdrId : number): void {
        this.classDtlInsertReqDto._classesId = classHdrId
        this.classDtlInsertSubscription = this.classDtlService.insert(this.classDtlInsertReqDto).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.classHdrGetAllSubscription?.unsubscribe()
        this.classDtlInsertSubscription?.unsubscribe()
    }

}