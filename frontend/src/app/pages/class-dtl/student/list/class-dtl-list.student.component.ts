import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ClassDtlListResDto } from "src/app/dto/class-dtl/class-dtl.list.res.dto";
import { ApiService } from "src/app/service/api.service";
import { ClassDtlService } from "src/app/service/class-dtl.service";

@Component({
    selector : 'class-dtl-list-std',
    templateUrl : './class-dtl-list.student.component.html'
})
export class ClassDtlListComponentStudent implements OnInit, OnDestroy{

    classDtlListResDto = new ClassDtlListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private classDtlGetAllIdStudentSubscription? : Subscription

    constructor(private classDtlService: ClassDtlService, private apiService : ApiService){}
    
    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.classDtlGetAllIdStudentSubscription = this.classDtlService.getAllIdStudent(Number(id)).subscribe(result => {
            this.classDtlListResDto = result
        })
    }

    ngOnDestroy(): void {
        this.classDtlGetAllIdStudentSubscription?.unsubscribe()
    }

}