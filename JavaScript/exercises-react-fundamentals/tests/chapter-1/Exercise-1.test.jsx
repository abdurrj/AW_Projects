const React = require('react');

const {
  findDOMNode
} = require('react-dom');

const {
  createRenderer
} = require('react-addons-test-utils');

describe('Exercise 1-1 - My first component', () => {
  it('Should have correct output', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponent
    } = require(`../../src/${__version__}/Exercise-1.jsx`);

    renderer.render(
      <MyFirstComponent />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        Hello World!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 1-2 - My second component', () => {
  it('Should have correct output', () => {
    let renderer = createRenderer();

    const {
      MySecondComponent
    } = require(`../../src/${__version__}/Exercise-1.jsx`);

    renderer.render(
      <MySecondComponent />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <h1>Amazing stuff</h1>
        <p>Is about to happen..</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});
