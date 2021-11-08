const React = require('react');

/**
 * DESCRIPTION:
 * Replace all occurrences of 'REPLACE_ME' in the unit tests below to make them
 * all pass (they should be green).
 */

let REPLACE_ME = () => <div/>;

/**
 * HINT
 * If you get stuck, you can go into '/tests/utils.js' and set 'global.hints = true'.
 * That way the error message will be more specific.
 * However, give it a try before you do this,
 * as in most cases this will give you the answer flat out.
 */



/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.1 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div class="awesome">
 *   Hi, my name is Eirik!
 * </div>
 *
 * if instantiated with:
 *
 * <MyFirstComponentWithProps
 *   name="Eirik"
 * />
 *
 */

const MyFirstComponentWithProps = class extends React.Component{
  render(){
    return(
      <div className="awesome">
        Hi, my name is {this.props.name}!
      </div>
    )
  }
};







/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.2 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div class="custom-class-1 custom-class-2">
 *   This is some amazing content!
 * </div>
 *
 * if instantiated with:
 *
 * <MySecondComponentWithProps
 *   customClasses={['custom-class-1', 'custom-class-2']}
 * />
 *
 */

const MySecondComponentWithProps = class extends React.Component{
  render(){
    return(
      <div className={this.props.customClasses.join(" ")}>
        This is some amazing content!
      </div>
    )
  }
};







/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.3 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </div>
 *
 * if instantiated with:
 *
 * <MyThirdComponentWithProps
 *   paragraphs={[
 *    'This is paragraph 1',
 *    'This is paragraph 2'
 *   ]}
 * />
 *
 * or
 *
 * <div>
 *   <p>This is paragraph 1 - goodbye</p>
 *   <p>This is paragraph 2 - world</p>
 *   <p>This is paragraph 3 - planet</p>
 *   <p>This is paragraph 4 - express</p>
 * </div>
 *
 * if instantiated with
 *
 * <MyThirdComponentWithProps
 *   paragraphs={[
 *     'This is paragraph 1 - goodbye',
 *     'This is paragraph 2 - world',
 *     'This is paragraph 3 - planet',
 *     'This is paragraph 4 - express'
 *   ]}
 * />
 */

const MyThirdComponentWithProps = class extends React.Component {
  render() {
    const paragraphList = this.props.paragraphs.map((paragraph, i) => {
      return <p key={i}>{paragraph.text}</p>;
    });

    return (
      <div>{paragraphList}</div>
    );
  }
};








/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.4 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <ul>
 *     <li>List 1 - Item 1</li>
 *     <li>List 1 - Item 2</li>
 *     ...
 *   </ul>
 *   <ul>
 *     <li>List 2 - Item 1</li>
 *     <li>List 2 - Item 2</li>
 *     ...
 *   </ul>
 *   ...
 * </div>
 *
 * if instantiated with:
 *
 * <MyFourthComponentWithProps
 *   lists={[
 *     ['List 1 - Item 1', 'List 1 - Item 2'],
 *     ['List 2 - Item 1', 'List 2 - Item 2']
 *   ]}
 * />
 *
 * (An array containing arrays)
 *
 */

const MyFourthComponentWithProps = REPLACE_ME;








/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.5 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </div>
 *
 * if instantiated with:
 *
 * <MyFifthComponentWithProps>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </MyFifthComponentWithProps>
 *
 */

const MyFifthComponentWithProps = REPLACE_ME;







/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.6 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </div>
 *
 * if instantiated with:
 *
 * <MySixthComponentWithProps showDetails={true}>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </MySixthComponentWithProps>
 *
 * And that outputs:
 *
 * <div>
 *
 * </div>
 *
 * if instantiated with:
 *
 * <MySixthComponentWithProps showDetails={false}>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </MySixthComponentWithProps>
 *
 */

const MySixthComponentWithProps = REPLACE_ME;







/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.7 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <h1>Awesome title</h1>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </div>
 *
 * if instantiated with:
 *
 * <MySeventhComponentWithProps title='Awesome title'>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </MySeventhComponentWithProps>
 *
 */

const MySeventhComponentWithProps = REPLACE_ME;







/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 3.8 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <h1>Awesome title</h1>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </div>
 *
 * if instantiated with:
 *
 * <MyEigthComponentWithProps title='Awesome title' showDetails={true}>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </MyEigthComponentWithProps>
 *
 * And should output:
 *
 * <div>
 *   <h1>Awesome title</h1>
 *   <p>No details..</p>
 * </div>
 *
 * if instantiated with:
 *
 * <MyEigthComponentWithProps title='Awesome title' showDetails={false}>
 *   <p>This is paragraph 1</p>
 *   <p>This is paragraph 2</p>
 * </MyEigthComponentWithProps>
 *
 */

const MyEigthComponentWithProps = REPLACE_ME;








/**
 * Exports
 */
module.exports = {
  MyFirstComponentWithProps,
  MySecondComponentWithProps,
  MyThirdComponentWithProps,
  MyFourthComponentWithProps,
  MyFifthComponentWithProps,
  MySixthComponentWithProps,
  MySeventhComponentWithProps,
  MyEigthComponentWithProps
};
