import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { LearningScheduleListResDto } from "../dto/learning-schedule/learning-schedule.list.res.dto";
import { LearningScheduleResDto } from "../dto/learning-schedule/learning-schedule.res.dto";

@Injectable({
    providedIn: 'root'
})
export class LearningScheduleService {
    constructor(private http: HttpClient) { }

    getAllIdClassDtl(id: number) : Observable<LearningScheduleListResDto>{
        return this.http.get<LearningScheduleListResDto>(`${BASE_URL.LOCALHOST}/learning_schedule/class-dtl/`+id);
    }
    
    getById(id:number) : Observable<LearningScheduleResDto>{
        return this.http.get<LearningScheduleResDto>(`${BASE_URL.LOCALHOST}/learning_schedule/id/`+id);
    }

}