import { QuizMaterialInsertDataResDto } from "./quiz-material.insert.data.res.dto";

export class QuizMaterialInsertResDto{
    private _data! : QuizMaterialInsertDataResDto
	private _message! : string

    public get data(): QuizMaterialInsertDataResDto {
        return this._data;
    }

    public set data(data: QuizMaterialInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}