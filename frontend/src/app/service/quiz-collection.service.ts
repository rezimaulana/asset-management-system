import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { QuizCollectionInsertReqDto } from "../dto/quiz-collection/quiz-collection.insert.req.dto";

@Injectable({
    providedIn: 'root'
})
export class QuizCollectionService {
    constructor(private http: HttpClient) { }

    insert(data :QuizCollectionInsertReqDto) : Observable<QuizCollectionInsertReqDto>{
        return this.http.post<QuizCollectionInsertReqDto>(`${BASE_URL.LOCALHOST}/quiz_collection`, data);
    }

}