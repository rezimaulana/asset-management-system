import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ExamCollectionInsertReqDto } from "../dto/exam-collection/exam-collection.insert.req.dto";

@Injectable({
    providedIn: 'root'
})
export class ExamCollectionService {
    constructor(private http: HttpClient) { }

    insert(data :ExamCollectionInsertReqDto) : Observable<ExamCollectionInsertReqDto>{
        return this.http.post<ExamCollectionInsertReqDto>(`${BASE_URL.LOCALHOST}/exam_collection`, data);
    }

}