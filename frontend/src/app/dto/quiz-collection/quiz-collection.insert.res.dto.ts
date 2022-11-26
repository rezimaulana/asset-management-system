import { QuizCollectionInsertDataResDto } from "./quiz-collection.insert.data.res.dto";

export class QuizCollectionInsertResDto{
    private _data! : QuizCollectionInsertDataResDto
	private _message! : string

    public get data(): QuizCollectionInsertDataResDto {
        return this._data;
    }

    public set data(data: QuizCollectionInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}