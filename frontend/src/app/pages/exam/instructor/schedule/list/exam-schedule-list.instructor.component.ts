import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ExamScheduleListResDto } from "src/app/dto/exam-schedule/exam-schedule.list.res.dto";
import { ExamScheduleService } from "src/app/service/exam-schedule.service";

@Component({
    selector : 'exam-schedule-list-ins',
    templateUrl : './exam-schedule-list.instructor.component.html'
})
export class ExamScheduleListComponentInstructor{
    examScheduleListResDto = new ExamScheduleListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    classHdrId! : number
    materialId! : number

    private examScheduleGetAllIdMaterialSubcription? : Subscription
    private getMaterialIdSubscription? : Subscription

    constructor(private activated : ActivatedRoute, private examScheduleService : ExamScheduleService){}
    
    init(){
        this.examScheduleGetAllIdMaterialSubcription = this.activated.parent?.parent?.parent?.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.classHdrId = idnum
            this.examScheduleService.getAllIdMaterial(idnum).subscribe(result => {
                this.examScheduleListResDto = result
            })
        })
        this.getMaterialIdSubscription = this.activated.params.subscribe(id => {
            this.materialId = Number(Object.values(id))
        })
    }

    ngOnInit(): void {
        this.init()
    }

    ngOnDestroy(): void {
        this.examScheduleGetAllIdMaterialSubcription?.unsubscribe()
        this.getMaterialIdSubscription?.unsubscribe()
    }
}