import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ExamMaterialListResDto } from "../dto/exam-material/exam-material.list.res.dto";
import { ExamMaterialResDto } from "../dto/exam-material/exam-material.res.dto";

@Injectable({
    providedIn: 'root'
})
export class ExamMaterialService {
    constructor(private http: HttpClient) { }

    getById(id:number) : Observable<ExamMaterialResDto>{
        return this.http.get<ExamMaterialResDto>(`${BASE_URL.LOCALHOST}/exam_material/id/`+id)
    }

    getAllIdClassHdr(id:number) : Observable<ExamMaterialListResDto>{
        return this.http.get<ExamMaterialListResDto>(`${BASE_URL.LOCALHOST}/exam_material/${id}`);
    }

}