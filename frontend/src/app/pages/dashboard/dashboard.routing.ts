import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { DashboardComponentSuperAdmin } from "./super-admin/dashboard.super-admin.component";
import { DashboardComponentInstructor } from "./instructor/dashboard.instructor.component";
import { DashboardComponentStudent } from "./student/dashboard.student.component";

const routes : Routes = [
    {
        path : "super-admin",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : DashboardComponentSuperAdmin
            }
        ]
    },
    {
        path : "instructor",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : DashboardComponentInstructor
            }
        ]
    },
    {
        path : "student",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : DashboardComponentStudent
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

export class DashboardRouting{}