import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ClassDtlInsertReqDto } from "../dto/class-dtl/class-dtl.insert.req.dto";
import { ClassDtlListResDto } from "../dto/class-dtl/class-dtl.list.res.dto";
import { ClassDtlResDto } from "../dto/class-dtl/class-dtl.res.dto";

@Injectable({
    providedIn: 'root'
})
export class ClassDtlService {
    constructor(private http: HttpClient) { }
    
    insert(data :ClassDtlInsertReqDto) : Observable<ClassDtlInsertReqDto>{
        return this.http.post<ClassDtlInsertReqDto>(`${BASE_URL.LOCALHOST}/class-dtl`, data);
    }

    getAllIdStudent(id : number) : Observable<ClassDtlListResDto>{
        return this.http.get<ClassDtlListResDto>(`${BASE_URL.LOCALHOST}/class-dtl/${id}`);
    }
    
    getById(id:number) : Observable<ClassDtlResDto>{
        return this.http.get<ClassDtlResDto>(`${BASE_URL.LOCALHOST}/class-dtl/id/`+id)
    }

}