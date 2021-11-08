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
 * 1.1 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>Hello World!</div>
 *
 */

const MyFirstComponent = class extends React.Component {
  render() {
    return (
      <div>
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
 * 1.2 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML:
 *
 * <div>
 *   <h1>Amazing stuff</h1>
 *   <p>Is about to happen..</p>
 * </div>
 *
 */

const MySecondComponent = class extends React.Component {
  render() {
    return (
      <div>
        <h1>Amazing stuff</h1>
        <p>Is about to happen..</p>
      </div>
    );
  }
};















/**
 * Exports
 */
module.exports = {
  MyFirstComponent,
  MySecondComponent
};
