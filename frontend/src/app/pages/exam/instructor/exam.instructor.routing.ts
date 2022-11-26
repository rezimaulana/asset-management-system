import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'class-hdr/:id',
        loadChildren : () => import('./material/exam-material.instructor.module').then(mod => mod.ExamMaterialModuleInstructor)
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

export class ExamRoutingInstructor{}