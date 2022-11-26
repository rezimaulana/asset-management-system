import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../../../service/api.service";

@Component({
    selector : 'app-header-ins',
    templateUrl : './header.instructor.component.html'
})
export class HeaderComponentInstructor {

    constructor(private apiService: ApiService, private router : Router){}

    logout(){
        this.apiService.logout()
        this.router.navigateByUrl('/login')
    }

}