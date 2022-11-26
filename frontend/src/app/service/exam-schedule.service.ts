import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ExamScheduleListResDto } from "../dto/exam-schedule/exam-schedule.list.res.dto";
import { ExamScheduleResDto } from "../dto/exam-schedule/exam-schedule.res.dto";

@Injectable({
    providedIn: 'root'
})
export class ExamScheduleService {
    constructor(private http: HttpClient) { }

    getAllIdClassDtl(id: number) : Observable<ExamScheduleListResDto>{
        return this.http.get<ExamScheduleListResDto>(`${BASE_URL.LOCALHOST}/exam_schedule/class-dtl/`+id);
    }
    
    getById(id:number) : Observable<ExamScheduleResDto>{
        return this.http.get<ExamScheduleResDto>(`${BASE_URL.LOCALHOST}/exam_schedule/id/`+id);
    }

    getAllIdMaterial(id: number) : Observable<ExamScheduleListResDto>{
        return this.http.get<ExamScheduleListResDto>(`${BASE_URL.LOCALHOST}/exam_schedule/`+id);
    }

}