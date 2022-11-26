import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ClassHdrListResDto } from "../dto/class-hdr/class-hdr.list.res.dto";
import { ClassHdrResDto } from "../dto/class-hdr/class-hdr.res.dto";

@Injectable({
    providedIn: 'root'
})
export class ClassHdrService {
    constructor(private http: HttpClient) { }

    getAll() : Observable<ClassHdrListResDto>{
        return this.http.get<ClassHdrListResDto>(`${BASE_URL.LOCALHOST}/class-hdr`);
    }

    getAllIdInstr(id:number) : Observable<ClassHdrListResDto>{
        return this.http.get<ClassHdrListResDto>(`${BASE_URL.LOCALHOST}/class-hdr/instructor/${id}`);
    }

    getById(id:number) : Observable<ClassHdrResDto>{
        return this.http.get<ClassHdrResDto>(`${BASE_URL.LOCALHOST}/class-hdr/`+id);
    } 

}