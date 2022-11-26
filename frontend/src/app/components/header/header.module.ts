import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HeaderComponentSuperAdmin } from "./super-admin/header.super-admin.component";
import { HeaderComponentInstructor } from "./instructor/header.instructor.component";
import { HeaderComponentStudent } from "./student/header.student.component";

@NgModule({
    declarations : [
        HeaderComponentSuperAdmin, HeaderComponentInstructor, HeaderComponentStudent
    ],
    imports : [
        RouterModule
    ],
    exports : [
        HeaderComponentSuperAdmin, HeaderComponentInstructor, HeaderComponentStudent
    ]
})
export class HeaderModule{}