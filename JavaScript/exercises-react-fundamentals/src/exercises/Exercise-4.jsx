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
 * 4.1 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML initially:
 *
 * <label class="CheckboxWithLabel">
 *   <input type="checkbox" checked="false" />
 *   Off
 * </label>
 *
 * But changes to the following when clicked:
 *
 * <label class="CheckboxWithLabel">
 *   <input type="checkbox" checked="true" />
 *   On
 * </label>
 *
 * when being instantiated with:
 *
 * <CheckboxWithLabel
 *   labelOn='On'
 *   labelOff='Off'
 * />
 *
 * HINT: the <input> element should have the following props/attributes:
 * - onChange
 */

const CheckboxWithLabel = REPLACE_ME;






/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 4.2 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML initially:
 *
 * <div>
 *   0
 * </div>
 *
 * But changes to the following when clicked once:
 *
 * <div>
 *   1
 * </div>
 *
 * and to the following when clicked twice:
 *
 * <div>
 *   2
 * </div>
 *
 * and so on.. :)
 *
 * when being instantiated with:
 *
 * <ClickCounter />
 *
 */

const ClickCounter = REPLACE_ME;






/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 4.3 Exercise description:
 *
 * Extend the functionality of the
 * previous click-counter by enabling
 * it to accept an initial count to start on,
 * rendering the following:
 *
 * <div>
 *   10
 * </div>
 *
 * But changes to the following when clicked once:
 *
 * <div>
 *   11
 * </div>
 *
 * and to the following when clicked twice:
 *
 * <div>
 *   12
 * </div>
 *
 * and so on..
 *
 * when being instantiated with:
 *
 * <ClickCounterWithInitialValue initialValue={10} />
 *
 */

const ClickCounterWithInitialValue = REPLACE_ME;






/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 4.4 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML initially:
 *
 * <div>
 *   <button>(+)</button>
 *   <button>(-)</button>
 *   <p>Count: 0</p>
 * </div>
 *
 * But changes to the following when the (+) button is clicked:
 *
 * <div>
 *   <button>(+)</button>
 *   <button>(-)</button>
 *   <p>Count: 1</p>
 * </div>
 *
 * or to the following when the (-) button is clicked:
 *
 * <div>
 *   <button>(+)</button>
 *   <button>(-)</button>
 *   <p>Count: -1</p>
 * </div>
 *
 * and so on..
 *
 * when being instantiated with:
 *
 * <IncrementDecrement />
 *
 */

const IncrementDecrement = REPLACE_ME;






/**
 * ------------------------
 * Your implementation here
 * ------------------------
 *
 * 4.5 Exercise description:
 *
 * Write a React component that outputs
 * the following HTML initially:
 *
 * <div>
 *   <button>(+)</button>
 *   <button>(-)</button>
 *   <p>Count: 0</p>
 * </div>
 *
 * But changes to the following when the (+) button is clicked:
 *
 * <div>
 *   <button>(+)</button>
 *   <button>(-)</button>
 *   <p>Count: 5</p>
 * </div>
 *
 * or to the following when the (-) button is clicked:
 *
 * <div>
 *   <button>(+)</button>
 *   <button>(-)</button>
 *   <p>Count: -5</p>
 * </div>
 *
 * and so on..
 *
 * when being instantiated with:
 *
 * <IncrementDecrementStep stepInterval={5} />
 *
 */

const IncrementDecrementStep = REPLACE_ME;

















/**
 * Exports
 */
module.exports = {
  CheckboxWithLabel,
  ClickCounter,
  ClickCounterWithInitialValue,
  IncrementDecrement,
  IncrementDecrementStep
};
