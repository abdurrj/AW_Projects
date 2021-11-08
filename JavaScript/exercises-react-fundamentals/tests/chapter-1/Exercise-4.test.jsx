/* eslint-disable */

const React = require('react');

const {
  findDOMNode
} = require('react-dom');

const {
  renderIntoDocument,
  findRenderedDOMComponentWithTag,
  scryRenderedDOMComponentsWithTag,
  Simulate
} = require('react-addons-test-utils');

describe('Exercise 4-1 - My first component with state and event handling', () => {
  it('changes the output text after one click', () => {
    const {
      CheckboxWithLabel
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const checkbox = renderIntoDocument(
      <CheckboxWithLabel
        labelOn="On"
        labelOff="Off"
      />
    );

    // Verify that it's Off by default
    const label = findRenderedDOMComponentWithTag(
      checkbox,
      'label'
    );

    assert.equal(
      findDOMNode(label).textContent,
      'Off',
      'Did not have correct initial label'
    );

    // Simulate a click and verify that it is now On
    const input = findRenderedDOMComponentWithTag(checkbox, 'input');
    Simulate.change(input);

    assert.equal(
      findDOMNode(label).textContent,
      'On',
      'Did not have correct label after click'
    );
  });

  it('changes the output text after two clicks', () => {
    const {
      CheckboxWithLabel
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const checkbox = renderIntoDocument(
      <CheckboxWithLabel
        labelOn="On"
        labelOff="Off"
      />
    );

    // Verify that it's Off by default
    const label = findRenderedDOMComponentWithTag(
      checkbox,
      'label'
    );

    assert.equal(
      findDOMNode(label).textContent,
      'Off',
      'Did not have correct initial label'
    );

    // Simulate a click and verify that it is now On
    const input = findRenderedDOMComponentWithTag(checkbox, 'input');
    Simulate.change(input);
    Simulate.change(input);

    assert.equal(
      findDOMNode(label).textContent,
      'Off',
      'Did not have correct label after two clicks'
    );
  });
});

describe('Exercise 4-2 - My second component with state and event handling', () => {
  it('changes the output text after one click', () => {
    const {
      ClickCounter
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <ClickCounter />
    );

    // Verify that it's Off by default
    const div = findRenderedDOMComponentWithTag(
      counter,
      'div'
    );

    assert.equal(
      findDOMNode(div).textContent,
      '0',
      'Did not have correct initial value'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(div);

    assert.equal(
      findDOMNode(div).textContent,
      '1',
      'Did not have correct count after click'
    );
  });

  it('changes the output text after four clicks', () => {
    const {
      ClickCounter
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <ClickCounter />
    );

    // Verify that it's Off by default
    const div = findRenderedDOMComponentWithTag(
      counter,
      'div'
    );

    assert.equal(
      findDOMNode(div).textContent,
      '0',
      'Did not have correct initial label'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(div);
    Simulate.click(div);
    Simulate.click(div);
    Simulate.click(div);

    assert.equal(
      findDOMNode(div).textContent,
      '4',
      'Did not have correct label after four clicks'
    );
  });
});

describe('Exercise 4-3 - My third component with state and event handling', () => {
  it('changes the output text after one click', () => {
    const {
      ClickCounterWithInitialValue
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <ClickCounterWithInitialValue initialValue={20} />
    );

    // Verify that it's Off by default
    const div = findRenderedDOMComponentWithTag(
      counter,
      'div'
    );

    assert.equal(
      findDOMNode(div).textContent,
      '20',
      'Did not have correct initial value'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(div);

    assert.equal(
      findDOMNode(div).textContent,
      '21',
      'Did not have correct count after click'
    );
  });

  it('changes the output text after four clicks', () => {
    const {
      ClickCounterWithInitialValue
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <ClickCounterWithInitialValue initialValue={40} />
    );

    // Verify that it's Off by default
    const div = findRenderedDOMComponentWithTag(
      counter,
      'div'
    );

    assert.equal(
      findDOMNode(div).textContent,
      '40',
      'Did not have correct initial label'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(div);
    Simulate.click(div);
    Simulate.click(div);
    Simulate.click(div);

    assert.equal(
      findDOMNode(div).textContent,
      '44',
      'Did not have correct label after four clicks'
    );
  });
});

describe('Exercise 4-4 - My fourth component with state and event handling', () => {
  it('changes the output text correctly', () => {
    const {
      IncrementDecrement
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <IncrementDecrement />
    );

    const incrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[0];

    const decrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[1];

    const countParagraph = findRenderedDOMComponentWithTag(
      counter,
      'p'
    );

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct initial value'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 1',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 2',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 3',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 2',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 1',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -1',
      'Did not have correct count after click (decrement)'
    );
  });
});

describe('Exercise 4-5 - My fifth component with state and event handling', () => {
  it('changes the output text correctly (with 5 as step interval)', () => {
    const {
      IncrementDecrementStep
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <IncrementDecrementStep stepInterval={5} />
    );

    const incrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[0];

    const decrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[1];

    const countParagraph = findRenderedDOMComponentWithTag(
      counter,
      'p'
    );

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct initial value'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 5',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 10',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 15',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 10',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 5',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -5',
      'Did not have correct count after click (decrement)'
    );
  });

  it('changes the output text correctly (with -10 as step interval)', () => {
    const {
      IncrementDecrementStep
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <IncrementDecrementStep stepInterval={-10} />
    );

    const incrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[0];

    const decrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[1];

    const countParagraph = findRenderedDOMComponentWithTag(
      counter,
      'p'
    );

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct initial value'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -10',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -20',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -30',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -20',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -10',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 10',
      'Did not have correct count after click (decrement)'
    );
  });

  it('changes the output text correctly (with 3 as step interval)', () => {
    const {
      IncrementDecrementStep
    } = require(`../../src/${__version__}/Exercise-4.jsx`);

    // Render a checkbox with label in the document
    const counter = renderIntoDocument(
      <IncrementDecrementStep stepInterval={3} />
    );

    const incrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[0];

    const decrementButton = scryRenderedDOMComponentsWithTag(
      counter,
      'button'
    )[1];

    const countParagraph = findRenderedDOMComponentWithTag(
      counter,
      'p'
    );

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct initial value'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 3',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 6',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(incrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 9',
      'Did not have correct count after click (increment)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 6',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 3',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: 0',
      'Did not have correct count after click (decrement)'
    );

    // Simulate a click and verify that it is now On
    Simulate.click(decrementButton);

    assert.equal(
      findDOMNode(countParagraph).textContent,
      'Count: -3',
      'Did not have correct count after click (decrement)'
    );
  });
});
