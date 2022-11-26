import { NgModule } from "@angular/core";
import { ProfileRouting } from "./profile.routing";
import { ProfileViewComponentSuperAdmin } from "./super-admin/view/profile-view.super-admin.component";
import { ProfileUpdateComponentSuperAdmin } from "./super-admin/update/profile-update.super-admin.component";
import { ProfilePasswordComponentSuperAdmin } from "./super-admin/password/profile-password.super-admin.component";
import { ProfileViewComponentInstructor } from "./instructor/view/profile-view.instructor.component";
import { ProfileUpdateComponentInstructor } from "./instructor/update/profile-update.instructor.component";
import { ProfilePasswordComponentInstructor } from "./instructor/password/profile-password.instructor.component";
import { ProfileViewComponentStudent } from "./student/view/profile-view.student.component";
import { ProfileUpdateComponentStudent } from "./student/update/profile-update.student.component";
import { ProfilePasswordComponentStudent } from "./student/password/profile-password.student.component";

@NgModule({
    declarations : [
        ProfileViewComponentSuperAdmin, ProfileUpdateComponentSuperAdmin, ProfilePasswordComponentSuperAdmin,
        ProfileViewComponentInstructor, ProfileUpdateComponentInstructor, ProfilePasswordComponentInstructor,
        ProfileViewComponentStudent, ProfileUpdateComponentStudent, ProfilePasswordComponentStudent
    ],
    imports : [
        ProfileRouting
    ],
    exports : [
        ProfileViewComponentSuperAdmin, ProfileUpdateComponentSuperAdmin, ProfilePasswordComponentSuperAdmin,
        ProfileViewComponentInstructor, ProfileUpdateComponentInstructor, ProfilePasswordComponentInstructor,
        ProfileViewComponentStudent, ProfileUpdateComponentStudent, ProfilePasswordComponentStudent
    ]
})

export class ProfiledModule{}