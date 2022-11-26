import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'instructor',
        loadChildren : () => import('./instructor/learning.instructor.module').then(mod => mod.LearningModuleInstructor)
    },
    {
        path : 'student',
        loadChildren : () => import('./student/learning.student.module').then(mod => mod.LearningModuleStudent)
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

export class LearningRouting{}