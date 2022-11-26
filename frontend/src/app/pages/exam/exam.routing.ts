import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'instructor',
        loadChildren : () => import('./instructor/exam.instructor.module').then(mod => mod.ExamModuleInstructor)
    },
    {
        path : 'student',
        loadChildren : () => import('./student/exam.student.module').then(mod => mod.ExamModuleStudent)
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

export class ExamRouting{}