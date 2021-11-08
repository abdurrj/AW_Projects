import React from 'react';
import { AppComponentProps, AppComponentState } from './types';
import Question from './Question'



class App extends React.Component<AppComponentProps, AppComponentState>{
  constructor(props: AppComponentProps){
    super(props);

    this.state = {
      questions: [
        {
          text: "Who is the president of the U.S.A?",
          alternatives: ["Donald Trump", "Joe Biden", "Joe Rogan", "Seth Rogen"],
          correctAnswer: 0,
          selectedAnswer: undefined
        },
        {
          text: "What is the capital of Norway?",
          alternatives: ["Trondheim", "Oslo", "Bergen", "Stavanger"],
          correctAnswer: 1,
          selectedAnswer: undefined
        },
      ],
      currentQuestionIndex: undefined
    }
  }

  handleStartQuiz(){
    this.setState({
      currentQuestionIndex: 0
    })
  }

  handleNext(){
    if (typeof this.state.currentQuestionIndex === 'number'){
      this.setState({
        currentQuestionIndex = this.state.currentQuestionIndex+1
      })
    }
  }
  handlePrevious(){
    if (typeof this.state.currentQuestionIndex === 'number'){
      this.setState({
        currentQuestionIndex = this.state.currentQuestionIndex+1
      })
    }
  }

  handleAnser(questionIndex: number, selectedAlternative: number){
    this.setState((oldState)=>)
  }


  render(){
    const cqi = this.state.currentQuestionIndex

    if (typeof cqi==='undefined'){
      return (
      <div>
        <h1>Welcome!</h1>
        <button onClick={()=>this.handleStartQuiz}>start quiz</button>
      </div>
      )
    }
    
    const activeQuestion = this.state.questions[cqi];

    return (
    <Question 
      question={activeQuestion}
      onNext={() =>this.handleNext()}
      onPrevious={()=> this.handlePrevious}
      onAnswer={(selectedAlternative: number)=>{
        this.handleAnser(cqi, selectedAlternative)
      }}
      >
    </Question>
    )
  }
}

export default App;
