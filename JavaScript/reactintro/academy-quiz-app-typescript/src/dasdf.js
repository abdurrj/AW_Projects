<html>
  <head>
    <title>Quiz</title>
  </head>
  <body>
    <div id="main"></div>
    
    <script>
      var mainNode = document.getElementById("main");

      /**
       * Our representation of the quiz questions
       * and answers (including what the user has selected)
       */
      var questions = [
        {
          text: "Who is the president of the U.S.A?",
          choices: ["Donald Trump", "Joe Biden", "Joe Rogan", "Seth Rogen"],
          correctAnswer: 0,
          selectedAnswer: undefined
        },
        {
          text: "What is the capital of Norway?",
          choices: ["Trondheim", "Oslo", "Bergen", "Stavanger"],
          correctAnswer: 1,
          selectedAnswer: undefined
        },
      ];

      /**
       * State representation of the
       * current question being answered
       */
      var currentQuestion = 0;

      /**
       * Function responsible for rendering
       * the welcome screen and attaching
       * any necessary events
       */
      function renderWelcome() {
        mainNode.innerHTML = `
          <h1>Welcome!</h1>
          <button id="start">Start quiz</button>
        `;

        var startButtonNode = document.getElementById("start");
        startButtonNode.addEventListener('click', function () {
          renderQuestion();
        });
      }

      /**
       * Function responsible for rendering
       * the current question and attaching
       * any necessary events
       */
      function renderQuestion() {
        var activeQuestion = questions[currentQuestion];

        var choiceList = activeQuestion.choices.map((choice, index) => `
          <div>
            <label>
              ${choice}
              <input name="choice" type="radio" value="${index}">
            </label>
          </div>
        `).join("");

        mainNode.innerHTML = `
          <h3>${activeQuestion.text}</h3>
          <div id="options">
            ${choiceList}
          </div>
          <button id="next">Next</button>
        `;

        var optionsNode = document.getElementById("options");
        optionsNode.addEventListener('click', function (event) {
          if (event.target.nodeName !== "INPUT") {
            return;
          }
          activeQuestion.selectedAnswer = +event.target.value;
        });

        var nextButtonNode = document.getElementById("next");
        nextButtonNode.addEventListener('click', function () {
          if (currentQuestion < questions.length - 1) {
            currentQuestion++;
            renderQuestion();
          } else {
            renderScore();
          }
        });
      }

      /**
       * Function responsible for rendering
       * the score screen and attaching
       * any necessary events
       */
      function renderScore() {
        const score = questions
        .filter(function (question) {
          return question.selectedAnswer === question.correctAnswer;
        }).length;

        mainNode.innerHTML = `
          <h1>Score: ${score}</h1>
          <button id="retry">Try again</button>
        `;

        var retryButtonNode = document.getElementById("retry");
        retryButtonNode.addEventListener('click', function () {
          currentQuestion = 0;
          questions.forEach(function (question) {
            question.selectedAnswer = undefined;
          });
          renderQuestion();
        });
      }

      /**
       * To initialize/start the app
       * we render the welcome screen
       */
      renderWelcome();
    </script>
  </body>
</html>