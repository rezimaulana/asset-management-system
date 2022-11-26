import { Component } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "src/app/constant/base.url";
import { ClassHdrListResDto } from "src/app/dto/class-hdr/class-hdr.list.res.dto";
import { ApiService } from "src/app/service/api.service";
import { ClassHdrService } from "src/app/service/class-hdr.service";

@Component({
    selector : 'class-hdr-list-ins',
    templateUrl : './class-hdr-list.instructor.component.html'
})
export class ClassHdrListComponentInstructor{
    classHdrListResDto = new ClassHdrListResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private classHdrGetAllSubscription? : Subscription

    constructor(private classHdrService: ClassHdrService, private apiService : ApiService){}

    init(){
        const id  = this.apiService.getUserId()
        this.classHdrGetAllSubscription = this.classHdrService.getAllIdInstr(Number(id)).subscribe(result => {
            this.classHdrListResDto = result
        })
    }
    
    ngOnInit(): void {
        this.init()
    }

    ngOnDestroy(): void {
        this.classHdrGetAllSubscription?.unsubscribe()
    }
}