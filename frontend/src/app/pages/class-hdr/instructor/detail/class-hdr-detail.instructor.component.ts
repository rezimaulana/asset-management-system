import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ClassHdrResDto } from "src/app/dto/class-hdr/class-hdr.res.dto";
import { ClassHdrService } from "src/app/service/class-hdr.service";

@Component({
    selector : 'class-hdr-detail-ins',
    templateUrl : './class-hdr-detail.instructor.component.html'
})
export class ClassHdrDetailComponentInstructor{
    classHdrResDto = new ClassHdrResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private classHdrGetByIdSubcription? : Subscription

    constructor(private activated : ActivatedRoute, private classHdrService : ClassHdrService){}
    
    ngOnInit(): void {
        this.classHdrGetByIdSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classHdrService.getById(idnum).subscribe(result => {
                this.classHdrResDto = result
            })
        })
    }
    ngOnDestroy(): void {
        this.classHdrGetByIdSubcription?.unsubscribe()
    }
}