import { QuizCollectionUpdateDataResDto } from "./quiz-collection.update.data.res.dto";

export class QuizCollectionUpdateResDto{
    private _data! : QuizCollectionUpdateDataResDto
	private _message! : string

    public get data(): QuizCollectionUpdateDataResDto {
        return this._data;
    }

    public set data(data: QuizCollectionUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}