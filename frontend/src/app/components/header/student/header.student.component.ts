import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../../../service/api.service";

@Component({
    selector : 'app-header-std',
    templateUrl : './header.student.component.html'
})
export class HeaderComponentStudent {

    constructor(private apiService: ApiService, private router : Router){}

    logout(){
        this.apiService.logout()
        this.router.navigateByUrl('/login')
    }

}