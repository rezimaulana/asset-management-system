import { Component, OnDestroy } from "@angular/core";
import { Router } from "@angular/router";
import { Subscription } from "rxjs";
import { ROLE_CONST } from "src/app/constant/role.const";
import { LoginReqDto } from "src/app/dto/login/login.req.dto";
import { ApiService } from "src/app/service/api.service";
import { UserService } from "src/app/service/user.service";

@Component({
    selector : 'login',
    templateUrl : './login.component.html'
})
export class LoginComponent implements OnDestroy{
    loginReqDto = new LoginReqDto()
    private loginSubscription? : Subscription

    constructor(private userService : UserService,
        private apiService : ApiService, private router : Router){}
    
    submit() : void {
        this.loginSubscription = this.userService.login(this.loginReqDto).subscribe(result => {
            console.log(`Result => ${JSON.stringify(result)}`)
            this.apiService.saveData(result)
            switch(result.roleCode){
                case ROLE_CONST.SUPERADMIN:
                    this.router.navigateByUrl('/dashboard/super-admin')
                    break;
                case ROLE_CONST.INSTRUCTOR:
                    this.router.navigateByUrl('/dashboard/instructor')
                    break;
                case ROLE_CONST.STUDENT:
                    this.router.navigateByUrl('/dashboard/student')
                    break;
                default:
                    this.router.navigateByUrl('/login')
                    break;
            }
        })
    }

    ngOnDestroy(): void {
        this.loginSubscription?.unsubscribe
    }
}