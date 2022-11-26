import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'instructor',
        loadChildren : () => import('./instructor/quiz.instructor.module').then(mod => mod.QuizModuleInstructor)
    },
    {
        path : 'student',
        loadChildren : () => import('./student/quiz.student.module').then(mod => mod.QuizModuleStudent)
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

export class QuizRouting{}