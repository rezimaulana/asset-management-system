import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HeaderModule } from "../header/header.module";
import { FooterComponent } from "../footer/footer.component";
import { ContentComponentSuperAdmin } from "./super-admin/content.super-admin.component";
import { ContentComponentInstructor } from "./instructor/content.instructor.component";
import { ContentComponentStudent } from "./student/content.student.component";

@NgModule({
    declarations : [
        ContentComponentSuperAdmin, ContentComponentInstructor, ContentComponentStudent, FooterComponent
    ],
    imports : [
        RouterModule, HeaderModule
    ],
    exports : [
        ContentComponentSuperAdmin, ContentComponentInstructor, ContentComponentStudent, FooterComponent
    ]
})
export class ContentModule{}