import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { LearningMaterialResDto } from "../dto/learning-material/learning-material.res.dto";

@Injectable({
    providedIn: 'root'
})
export class LearningMaterialService {
    constructor(private http: HttpClient) { }

    getById(id:number) : Observable<LearningMaterialResDto>{
        return this.http.get<LearningMaterialResDto>(`${BASE_URL.LOCALHOST}/learning_material/id/`+id)
    }

}