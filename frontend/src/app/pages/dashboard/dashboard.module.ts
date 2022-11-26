import { NgModule } from "@angular/core";
import { DashboardRouting } from "./dashboard.routing";
import { DashboardComponentSuperAdmin } from "./super-admin/dashboard.super-admin.component";
import { DashboardComponentInstructor } from "./instructor/dashboard.instructor.component";
import { DashboardComponentStudent } from "./student/dashboard.student.component";

@NgModule({
    declarations : [
        DashboardComponentSuperAdmin, DashboardComponentInstructor, DashboardComponentStudent
    ],
    imports : [
        DashboardRouting
    ],
    exports : [
        DashboardComponentSuperAdmin, DashboardComponentInstructor, DashboardComponentStudent
    ]
})

export class DashboardModule{}