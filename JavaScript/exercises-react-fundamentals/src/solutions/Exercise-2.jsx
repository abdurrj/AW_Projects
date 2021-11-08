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
 * 2.1 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div class="awesome">Hello World!</div>
 *
 */

const MyFirstComponentWithClasses = class extends React.Component {
  render() {
    return (
      <div className="awesome">
        Hello World!
      </div>
    );
  }
};







/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 2.2 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div class="awesome-container">
 *   <p class="awesome-paragraph">Hello World!</p>
 * </div>
 *
 */

const MySecondComponentWithClasses = class extends React.Component {
  render() {
    return (
      <div className="awesome-container">
        <p className="awesome-paragraph">Hello World!</p>
      </div>
    );
  }
};








/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 2.3 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML and inline styles:
 *
 * <div> // Inline styles - background-color: red | margin-top: 15px
 *   <p>Hello World!</p> // Inline styles - color: yellow | margin-bottom: 15px
 * </div>
 *
 */

const MyFirstComponentWithInlineStyles = class extends React.Component {
  render() {
    return (
      <div style={{ backgroundColor: 'red', marginTop: '15px' }}>
        <p style={{ color: 'yellow', marginBottom: '15px' }}>Hello World!</p>
      </div>
    );
  }
};








/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 2.4 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML and inline styles and classes:
 *
 * <div> // Inline styles - padding: 20px | border: 1px solid black
 *   <p>Hello World!</p> // Inline styles - background-color: green | color: brown
 * </div>
 *
 */

const MySecondComponentWithInlineStyles = class extends React.Component {
  render() {
    return (
      <div style={{ padding: '20px', border: '1px solid black' }}>
        <p style={{ backgroundColor: 'green', color: 'brown' }}>Hello World!</p>
      </div>
    );
  }
};









/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 2.5 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML, classes and inline styles:
 *
 * <div class="awesome-container"> // Inline styles - padding: 20px | border: 1px solid black
 *   <p class="awesome-paragraph">Hello World!</p> // Inline styles - background-color: green | color: brown
 * </div>
 *
 */

const MyFirstComponentWithInlineStylesAndClasses = class extends React.Component {
  render() {
    return (
      <div className="awesome-container" style={{ padding: '20px', border: '1px solid black' }}>
        <p className="awesome-paragraph" style={{ backgroundColor: 'green', color: 'brown' }}>Hello World!</p>
      </div>
    );
  }
};













/**
 * Exports
 */
module.exports = {
  MyFirstComponentWithClasses,
  MySecondComponentWithClasses,
  MyFirstComponentWithInlineStyles,
  MySecondComponentWithInlineStyles,
  MyFirstComponentWithInlineStylesAndClasses
};
