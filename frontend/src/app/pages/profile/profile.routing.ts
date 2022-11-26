import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";
import { ProfileViewComponentSuperAdmin } from "./super-admin/view/profile-view.super-admin.component";
import { ProfileUpdateComponentSuperAdmin } from "./super-admin/update/profile-update.super-admin.component";
import { ProfilePasswordComponentSuperAdmin } from "./super-admin/password/profile-password.super-admin.component";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ProfileViewComponentInstructor } from "./instructor/view/profile-view.instructor.component";
import { ProfileUpdateComponentInstructor } from "./instructor/update/profile-update.instructor.component";
import { ProfilePasswordComponentInstructor } from "./instructor/password/profile-password.instructor.component";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { ProfileViewComponentStudent } from "./student/view/profile-view.student.component";
import { ProfileUpdateComponentStudent } from "./student/update/profile-update.student.component";
import { ProfilePasswordComponentStudent } from "./student/password/profile-password.student.component";

const routes : Routes = [
    {
        path : "super-admin",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : ProfileViewComponentSuperAdmin
            },
            {
                path: "update",
                component : ProfileUpdateComponentSuperAdmin
            },
            {
                path: "password",
                component : ProfilePasswordComponentSuperAdmin
            }
        ]
    },
    {
        path : "instructor",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ProfileViewComponentInstructor
            },
            {
                path: "update",
                component : ProfileUpdateComponentInstructor
            },
            {
                path: "password",
                component : ProfilePasswordComponentInstructor
            }
        ]
    },
    {
        path : "student",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : ProfileViewComponentStudent
            },
            {
                path: "update",
                component : ProfileUpdateComponentStudent
            },
            {
                path: "password",
                component : ProfilePasswordComponentStudent
            }
        ]
    }
];

@NgModule({
    imports : [
        RouterModule.forChild(routes)
    ],
    exports : [
        RouterModule
    ]
})

export class ProfileRouting{}