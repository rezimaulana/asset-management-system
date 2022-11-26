import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'super-admin',
        loadChildren : () => import('./super-admin/class-hdr.super-admin.module').then(mod => mod.ClassHdrModuleSuperAdmin)
    },
    {
        path : 'instructor',
        loadChildren : () => import('./instructor/class-hdr.instructor.module').then(mod => mod.ClassHdrModuleInstructor)
    },
    {
        path : 'student',
        loadChildren : () => import('./student/class-hdr.student.module').then(mod => mod.ClassHdrModuleStudent)
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

export class ClassHdrRouting{}