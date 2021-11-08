import React from 'react';
import { Question } from './types'

interface QuestionComponentProps {
    question: Question,
    onNext: () => void;
    onPrevious: () => void;
    onAnswer: (selectedAlternative: number) => void;
}

class QuestionComponent extends React.Component<QuestionComponentProps>{
    render(){
        return <div>Her kommer spørsmål</div>
    }
    
}

export default QuestionComponent;