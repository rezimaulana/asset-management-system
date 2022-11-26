import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { LoginReqDto } from "../dto/login/login.req.dto";
import { LoginResDto } from "../dto/login/login.res.dto";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";

@Injectable({
    providedIn : 'root'
})

export class UserService {

    constructor(private http : HttpClient) {}

    login(data : LoginReqDto) : Observable<LoginResDto> {
        return this.http.post<LoginResDto>(`${BASE_URL.LOCALHOST}/login`, data)
    }
    
}