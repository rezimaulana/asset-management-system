import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { QuizMaterialResDto } from "../dto/quiz-material/quiz-material.res.dto";

@Injectable({
    providedIn: 'root'
})
export class QuizMaterialService {
    constructor(private http: HttpClient) { }

    getById(id:number) : Observable<QuizMaterialResDto>{
        return this.http.get<QuizMaterialResDto>(`${BASE_URL.LOCALHOST}/quiz_material/id/`+id)
    }

}