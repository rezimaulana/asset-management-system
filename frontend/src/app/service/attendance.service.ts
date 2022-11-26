import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { AttendanceInsertReqDto } from "../dto/attendance/attendance.insert.req.dto";
import { AttendanceListResDto } from "../dto/attendance/attendance.list.res.dto";
import { AttendanceUpdateReqDto } from "../dto/attendance/attendance.update.req.dto";

@Injectable({
    providedIn: 'root'
})
export class AttendanceService {
    constructor(private http: HttpClient) { }
    
    insert(data :AttendanceInsertReqDto) : Observable<AttendanceInsertReqDto>{
        return this.http.post<AttendanceInsertReqDto>(`${BASE_URL.LOCALHOST}/attendance`, data);
    }
    
    getAttendExam(id:number) : Observable<AttendanceListResDto>{
        return this.http.get<AttendanceListResDto>(`${BASE_URL.LOCALHOST}/attendance/exam_schedule/${id}`);
    }

    getAttendQuiz(id:number) : Observable<AttendanceListResDto>{
        return this.http.get<AttendanceListResDto>(`${BASE_URL.LOCALHOST}/attendance/quiz_schedule/${id}`);
    }

    getAttendLearning(id:number) : Observable<AttendanceListResDto>{
        return this.http.get<AttendanceListResDto>(`${BASE_URL.LOCALHOST}/attendance/learning_schedule/${id}`);
    }

    update(data :AttendanceUpdateReqDto) : Observable<AttendanceUpdateReqDto>{
        return this.http.put<AttendanceUpdateReqDto>(`${BASE_URL.LOCALHOST}/attendance`, data);
    }
}