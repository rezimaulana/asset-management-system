import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { QuizScheduleListResDto } from "../dto/quiz-schedule/quiz-schedule.list.res.dto";
import { QuizScheduleResDto } from "../dto/quiz-schedule/quiz-schedule.res.dto";

@Injectable({
    providedIn: 'root'
})
export class QuizScheduleService {
    constructor(private http: HttpClient) { }

    getAllIdClassDtl(id: number) : Observable<QuizScheduleListResDto>{
        return this.http.get<QuizScheduleListResDto>(`${BASE_URL.LOCALHOST}/quiz_schedule/class-dtl/`+id);
    }
    
    getById(id:number) : Observable<QuizScheduleResDto>{
        return this.http.get<QuizScheduleResDto>(`${BASE_URL.LOCALHOST}/quiz_schedule/id/`+id);
    }

}